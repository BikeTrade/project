
      
const Carousel =ReactBootstrap.Carousel; 

const CheckBox = props => {
    return (    
      <li>
       <input key={props.id} onClick={props.handleCheckChieldElement} type="checkbox" checked={props.isChecked} value={props.value} /> {props.value}
      </li>
    )
}

const Menu = props => { 

  return (<div className="item">
	    <div className="header">{props.menuId}</div>
	    <div className="menu">
	      <ul>
	        {
	          props.facets.map((menuItem) => {
	            return (<CheckBox handleCheckChieldElement={props.handleCheckChieldElement}  {...menuItem} />)
	          })
	        }
        </ul>
	    </div>
	  </div>);  
}



const ViewBike = props => {
    return (	  <div className="column">
					    <div className="ui segment">
				       	<div className="ui medium bordered image">
					       <Carousel>
								  <Carousel.Item style={{'height':"300px"}}>
								    <img style={{'height':"300px"}}
								      className="d-block w-100"
								      src={`data:${props.bike.frontImgType};base64,${props.bike.frontImg}`}
								      alt="First slide"
								    />
								  </Carousel.Item>
								   <Carousel.Item style={{'height':"300px"}}>
								    <img  style={{'height':"300px"}}
								      className="d-block w-100"
								      src={`data:${props.bike.backImgType};base64,${props.bike.backImg}`}
								      alt="First slide"
								    />
								  </Carousel.Item>
								   <Carousel.Item style={{'height':"300px"}}>
								    <img style={{'height':"300px"}}
								      className="d-block w-100"
								      src={`data:${props.bike.leftImgType};base64,${props.bike.leftImg}`}
								      alt="First slide"
								    />
								  </Carousel.Item>
								   <Carousel.Item style={{'height':"300px"}}>
								    <img style={{'height':"300px"}}
								      className="d-block w-100"
								      src={`data:${props.bike.rightImgType};base64,${props.bike.rightImg}`}
								      alt="First slide"
								    />
								  </Carousel.Item>
							 </Carousel>
				       		 <span> {props.bike.id} </span> <br></br>
				       		 <span>Brand {props.bike.brand} </span> <br></br>        
					       	 <span> Model {props.bike.modelName} </span><br></br> 
					       	 <span>Price {props.bike.price} </span><br></br> 
				          	 <span>Location {props.bike.bLocation} </span><br></br> 
				             <span>Running {props.bike.running} </span><br></br> 
				          	 <div class="ui labeled button" tabindex="0">
								  <div class="ui blue button">
								    <i class="heart icon"></i> Like
								  </div>
								  <a class="ui basic blue left pointing label">
								    0
								  </a>
							</div>
							<button class="positive ui button">Buy</button>
				       </div>
     	    </div>
	  </div> 
    )
}


      
      
   class App extends React.Component { 
   state = {
      brands: [
		        {id: 1, value: "HERO", isChecked: false},
				{id: 2, value: "YAMAHA", isChecked: false},
				{id: 3, value: "TVS", isChecked: false},
				{id: 4, value: "HONDA", isChecked: false},
				{id: 5, value: "ROYALENFIELD", isChecked: false},
				{id: 6, value: "JAVA", isChecked: false},
				{id: 7, value: "SUZUKI", isChecked: false},
				{id: 8, value: "BAJAJ", isChecked: false},
				{id: 9, value: "KTM", isChecked: false},
				{id: 10, value: "REVOLT", isChecked: false},
				{id: 11, value: "CFMOTO", isChecked: false}
		      ],
      brandSelectedOptions: [],
       priceRange: [
			        {id: 1, value: "1_to_20000", isChecked: false},
					{id: 2, value: "20000_to_50000", isChecked: false},
					{id: 3, value: "50000_to_75000", isChecked: false},
					{id: 4, value: "75000_more", isChecked: false}
				   ],
		priceRangeSelectedOptions: [],
		kmRange:[
					{id: 1, value:"1_to_5000"      , isChecked: false},
					{id: 2, value:"5000_to_25000"  , isChecked: false},
					{id: 3, value:"25000_to_50000" , isChecked: false},
					{id: 4, value:"50000_more"     , isChecked: false}
				],
		kmRangeOption: [],	
		city:[
					{id:1, value:"Mumbai", isChecked: false},
					{id:2, value:"Pune", isChecked: false},
					{id:3, value:"Satara", isChecked: false},
					{id:4, value:"Bangalore", isChecked: false},
					{id:5, value:"Dehli", isChecked: false},
					{id:6, value:"Chennai", isChecked: false},
					{id:7, value:"Ahmadabad", isChecked: false},
					{id:8, value:"Chandigarh", isChecked: false},
					{id:8, value:"Patana", isChecked: false},
				],
		cityOption: [],						   
      bikes : []
    }

 	componentDidMount() {
 	this.getBikeDetails();
  }
  
  getBikeDetails=()=>{
    const brandFilter = this.state.brandSelectedOptions.length === 0 ? '*' : this.state.brandSelectedOptions.toString();
  	const priceRangeFilter = this.state.priceRangeSelectedOptions.length === 0 ? '*' : this.state.priceRangeSelectedOptions.toString();
  	const kmRangeFilter = this.state.kmRangeOption.length === 0 ? '*' : this.state.kmRangeOption.toString();
  	const cityRangeFilter = this.state.cityOption.length === 0 ? '*' : this.state.cityOption.toString();
  console.log('getBikeDetails '+brandFilter+ '  '+ priceRangeFilter+'  '+kmRangeFilter);
			     axios.get('http://localhost:8080/biketrade/bike/details',
			     { params: {
			      			filter:brandFilter,
			      			priceRangeFilter: priceRangeFilter,
			      			kmRangeFilter : kmRangeFilter,
			      			cityRangeFilter:cityRangeFilter
			   			 }})
			      .then(res => {
			        	this.setState({bikes: res.data });}, 
			      (error) => {
					    console.log(error);
				})
  }
  
  handleCheckChieldElement = (event) => {
    let brands = this.state.brands;   
    brands.forEach(brand => {
       if (brand.value === event.target.value)
          {
         	 brand.isChecked =  event.target.checked; 
         	 let index = this.state.brandSelectedOptions.indexOf(brand.value);
	    	 if(index === -1) 
	         	 {		         	   
		         	 this.setState({brandSelectedOptions : [...this.state.brandSelectedOptions,brand.value]},
		         	 () => {
          		 		this.getBikeDetails();
          			 });  
	         	 }
         	   	 
          }
    })
        
    this.setState({brands: brands});
    if(event.target.checked === false){
    	 let index = this.state.brandSelectedOptions.indexOf(event.target.value);
    	 if(index !== -1)
          	{
          		 this.onRemoveBrandItem(event.target.value);
          	}
    	} 
  }
  
  
  onRemoveBrandItem = i =>{ 
  	this.setState(state => {
			      const brandSelectedOptions = state.brandSelectedOptions.filter(function (str) { return !str.includes(i); });			    		 
			      return {
			        brandSelectedOptions,
			      };
			    },() => this.getBikeDetails());  
  }
  
  
  onRemovePriceItem = i =>{ 
  	this.setState(state => {
			      const priceRangeSelectedOptions = state.priceRangeSelectedOptions.filter(function (str) { return !str.includes(i); });			    		 
			      return {
			        priceRangeSelectedOptions,
			      };
			    },() => this.getBikeDetails());  
  }
  
  handlePriceRangeElement = (event) => {  
    let priceRange = this.state.priceRange;
    let priceRangeSelectedOptions = this.state.priceRangeSelectedOptions;
    priceRange.forEach(price => {
       if (price.value === event.target.value)
          {
         	 price.isChecked =  event.target.checked; 
         	 let index = priceRangeSelectedOptions.indexOf(price.value);
         	 if(index === -1){ 
	         	 
	         	 this.setState({priceRangeSelectedOptions : [...priceRangeSelectedOptions,price.value]},() => {
          		 	this.getBikeDetails();
          		 }); 
         	 } 	 
          }
    }) 
       
    this.setState({priceRange: priceRange});
    if(event.target.checked === false){
    
    	 let index = priceRangeSelectedOptions.indexOf(event.target.value);
    	 if(index !== -1)
          	{
          		  this.onRemovePriceItem(event.target.value);  		 
          	}
    	}
  }
  
    onRemoveKmItem = i =>{ 
  	this.setState(state => {
			      const kmRangeOption = state.kmRangeOption.filter(function (str) { return !str.includes(i); });			    		 
			      return {
			        kmRangeOption,
			      };
			    },() => this.getBikeDetails());  
  }
  
  handleKmRangeElement = (event) => {  
    let kmRange = this.state.kmRange;
    let kmRangeOption = this.state.kmRangeOption;
    kmRange.forEach(km => {
       if (km.value === event.target.value)
          {
         	 km.isChecked =  event.target.checked; 
         	 let index = kmRangeOption.indexOf(km.value);
         	 if(index === -1){ 
	         	 
	         	 this.setState({kmRangeOption : [...kmRangeOption,km.value]},() => {
          		 	this.getBikeDetails();
          		 }); 
         	 } 	 
          }
    }) 
       
    this.setState({kmRange: kmRange});
    if(event.target.checked === false){
    
    	 let index = kmRangeOption.indexOf(event.target.value);
    	 if(index !== -1)
          	{
          		  this.onRemoveKmItem(event.target.value);  		 
          	}
    	}
  }
  
   onRemoveCtItem = i =>{ 
  	this.setState(state => {
			      const cityOption = state.cityOption.filter(function (str) { return !str.includes(i); });			    		 
			      return {
			        cityOption,
			      };
			    },() => this.getBikeDetails());  
  }
  
  
  handleSelectedCityElement = (event) => {  
    let city = this.state.city;
    let cityOption = this.state.cityOption;
    city.forEach(ct => {
       if (ct.value === event.target.value)
          {
         	 ct.isChecked =  event.target.checked; 
         	 let index = cityOption.indexOf(ct.value);
         	 if(index === -1){ 
	         	 
	         	 this.setState({cityOption : [...cityOption,ct.value]},() => {
          		 	this.getBikeDetails();
          		 }); 
         	 } 	 
          }
    }) 
       
    this.setState({city: city});
    if(event.target.checked === false){
    
    	 let index = cityOption.indexOf(event.target.value);
    	 if(index !== -1)
          	{
          		  this.onRemoveCtItem(event.target.value);  		 
          	}
    	}
  }
  

  render() {
    return (
			<div className="ui segment">
				 
					    <div className="row">
					  		<div className="col-3 menu">						
									<div className="ui vertical menu">
										<Menu menuId='Brands'  facets={this.state.brands}  handleCheckChieldElement={this.handleCheckChieldElement}  />
										<Menu menuId='Price Range'  facets={this.state.priceRange}  handleCheckChieldElement={this.handlePriceRangeElement}  />
										<Menu menuId='KM Range'  facets={this.state.kmRange}  handleCheckChieldElement={this.handleKmRangeElement}  />
										<Menu menuId='Cities'  facets={this.state.city}  handleCheckChieldElement={this.handleSelectedCityElement}  />
									</div>						
							</div>
							<div className="col-9">	
								<div className="ui three column grid">	
									{
									this.state.bikes.map((bike) => {
										return (<ViewBike bike={bike} />)
									})
									}			
								</div>
							</div>
						</div>
							
			</div>    
    );
  }
}   
      

      ReactDOM.render(<App/>, document.getElementById('mydiv'))