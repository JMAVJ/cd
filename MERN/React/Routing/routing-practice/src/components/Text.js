import React from 'react'
import { useParams } from 'react-router'

const Text = () => {
  const { str, color, background} = useParams()
  
  return (
    <div style={{color, background}}>
      <h1>Text: {str}</h1>
    </div>
  )
}

export default Text
