import React, {useState} from 'react'

const PersonCard = (props) => {
  const [dynamicAge, setDynamicAge] = useState(props.age)

  const handleClick = () => {
    setDynamicAge(dynamicAge + 1)
  }
  
  return (
    <div>
      <h1>Name: {props.firstName} {props.lastName}</h1>
      <p>Age: {dynamicAge}</p>
      <p>Hair Color: {props.hairColor}</p>
      <button onClick={() => handleClick()}>Birthday Button</button>
    </div>
  )
}

export default PersonCard
