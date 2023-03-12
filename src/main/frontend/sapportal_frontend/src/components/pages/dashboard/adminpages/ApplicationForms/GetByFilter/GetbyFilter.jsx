// import React from "react";
// import { useState } from "react";
// //import { Dropdown, DropdownButton } from "react-bootstrap";
// const GetbyFilter = () => {
//     const [showid, setshowid] = useState(false)
//     const handleselect = (e) => {
//         console.log(e.target.value)
//         if(e.target.value === "userid" ){
//             setshowid(true)
//         }
//     }
    
    
//     return (
//         <div>
//            <select name="cars" id="cars" onChange={handleselect}>
//     <option value="volvo">Volvo</option>
//     <option value="userid">User Id</option>
//     <option value="opel">Opel</option>
//     <option value="audi">Audi</option>
//   </select>


//   {
//           showid &&  <>
//             <div className="container">
//                 Hii
//             </div>
//             <div></div></>
          
//         }
//         </div>
//     )
// }

// export default GetbyFilter;
//-----------------------------------------------------
import React ,{ useEffect, useState} from "react";
import axios from "axios";
export default function GetbyFilter() {
    const [data, setData] = useState([]);

    useEffect(() => {
        (async () => {
          try {
            const { data } = await axios.get("http://localhost:9190//api/fetchlistofApplicationFormbyfilter",{
                params: {
                    applicationFromStatus : "initial"
                }
            });
            setData(data.records);
            console.log(data);
          } catch (error) {
            console.log("Error");
          }
        })();
      }, []);

    return (
        <div>
            <table>
                <thead>
                    <th>Name</th>
                </thead>
                <tbody>
                {data.map((ele) => {
                    return (
                        <tr>
                            <td style={{ width: "100px", padding: "8px" }}>
                            {ele.name}
                            </td>
                        </tr>
                    )
                })}
                </tbody>
        
        </table>
        </div>
    )

}