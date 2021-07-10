import { useParams } from 'react-router'

const Number = () => {
  let { num } = useParams()

  return (
    <h1>Number: {num}</h1>
  )
}

export default Number
