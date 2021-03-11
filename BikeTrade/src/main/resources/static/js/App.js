
      
      
const CheckBox = props => {
    return (
      <li>
       <input key={props.id} onClick={props.handleCheckChieldElement} type="checkbox" checked={props.isChecked} value={props.value} /> {props.value}
      </li>
    )
}

const ViewImage = props => {
    return (
     
       <div className="image-list">
       <span> {props.bike.id} </span> <br></br>
       <span>Brand {props.bike.brand} </span> <br></br>        
	       <span> Model {props.bike.modelName} </span><br></br> 
	       <span>Price {props.bike.price} </span><br></br> 
          <span>Contact Name {props.bike.contactName} </span><br></br> 
          <span>Contact Number {props.bike.contactNo} </span><br></br> 
          <img alt="img" src={`data:${props.bike.frontImgType};base64,${props.bike.frontImg}`}/>
       </div>
     
    )
}
    
      
      
   class App extends React.Component { 
   state = {
      brands: [
        {id: 1, value: "Yamaha", isChecked: false},
        {id: 2, value: "Honda", isChecked: false},
        {id: 3, value: "Hero", isChecked: false},
        {id: 4, value: "Suzuki", isChecked: false}
      ],
      bikes : []
    }

 componentDidMount() {
    axios.get('http://localhost:8080/biketrade/bike/*')
      .then(res => {
        const bikes = res.data;
        this.setState({bikes: bikes });
        console.log(bikes);
      })
  }
  
  handleAllChecked = (event) => {
    let brands = this.state.brands
    brands.forEach(brand => brand.isChecked = event.target.checked) 
    this.setState({brands: brands})
  }

  handleCheckChieldElement = (event) => {
    let brands = this.state.brands
    brands.forEach(brand => {
       if (brand.value === event.target.value)
          brand.isChecked =  event.target.checked
    })
    this.setState({brands: brands})
  }

  render() {
    return (
      <div className="App">
      <h1> Used Bikes </h1>
      <input type="checkbox" onClick={this.handleAllChecked}  value="checkedall" /> Check / Uncheck All
        <ul>
        {
          this.state.brands.map((brand) => {
            return (<CheckBox handleCheckChieldElement={this.handleCheckChieldElement}  {...brand} />)
          })
        }
        </ul>
        
        <div className="Images">
         {
          this.state.bikes.map((bike) => {
            return (<ViewImage bike={bike} />)
          })
        }
        </div>
      </div>
      
    );
  }
}   
      

      ReactDOM.render(<App/>, document.getElementById('mydiv'))