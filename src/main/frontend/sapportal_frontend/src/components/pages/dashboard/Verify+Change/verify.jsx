import axios from "axios"
import { response } from "express"
import React, { useEffect, useState } from "react"

const UsingAxios = () => {
  const [message, setUsers] = useState([])

  const fetchData = () => {
    axios.get("http://localhost:9190/api/auth/forgotpassword/{Email}").then(response => {
      setUsers(response.data)
    })
  }

  useEffect(() => {
    fetchData()
  }, [])

  return (
    <div>
      {message.length > 0 && (
        <ul>
          Message : {response.data}
        </ul>
      )}
    </div>
  )
}

export default UsingAxios