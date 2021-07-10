import React from 'react'
import { useParams } from 'react-router'

const TextOnly = () => {  
  const { str } = useParams()

  return (
    <h1>Text: {str}</h1>
  )
}

export default TextOnly
