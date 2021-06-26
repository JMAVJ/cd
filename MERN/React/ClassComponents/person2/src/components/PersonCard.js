import React, { Component } from 'react'

export default class PersonCard extends Component {
  constructor(props) {
    super(props)
    this.state = {
      dynamicAge: null,
    }
  }

  componentDidMount() {
    this.setState({
      dynamicAge: this.props.age,
    })
  }
  
  updateAge = () => {
    this.setState({
      dynamicAge: this.state.dynamicAge + 1,
    })
  }

  render() {
    const {firstName, lastName, hairColor} = this.props
    const {dynamicAge} = this.state
    return (
      <div>
        <h1>{lastName}, {firstName}</h1>
        <p>Age: {dynamicAge}</p>
        <p>Hair Color: {hairColor}</p>
        <button onClick={() => this.updateAge()}>Birthday Button for {firstName} {lastName}</button>
      </div>
    )
  }
}