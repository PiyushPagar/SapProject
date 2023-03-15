// import React ,{ useEffect, useState} from "react";
// import axios from "axios";
// export default function VerifyForm() {
//     const [data, setData] = useState([]);
//     //const [show, setShow] = useState(false);
//     //const [Sid,setSid] = useState(0);
//     //const [stat,setstat] = useState("")
//     const onClicked = () => {
//         return (
//             <div>

//             </div>
//         )
//     }
//     const onVerify = () => {
//         return (
//             <div>

//             </div>
//         )
//     }

//     useEffect(() => {
//         (async () => {
//           try {
//             const { data } = await axios.get("http://localhost:9190/api/fetchlistofApplicationFormbyfilter",{
//                 params: {
//                     pagesize : 20,
//                     pagenum : 0,
//                     applicationFromStatus : "active"
//                 }
//             });
//             setData(data.records);
//             //setSid(data.records.student_id);
//             console.log(data);
//           } catch (error) {
//             console.log("Error");
//           }
//         })();
//       }, []);

//     return (
//         <div style={{display : "flex", justifyContent :"center"}}>
            
//             <table border={5} style={{height : "50%", width : "80%"}}>
//                 <thead>
//                     <tr>
//                     <th>Name</th>
//                     <th>Adhar Number</th>
//                     <th>Contact Number</th>
//                     <th>Branch</th>
//                     <th>SAP Module</th>
//                     <th>Email</th>
//                     <th>Specialization</th>
//                     <th>Student Type</th>
//                     <th>College Email</th>
//                     <th>Passout Year</th>
//                     <th>Image</th>
//                     <th>Form Status</th>
//                     <th>Action</th>
//                     </tr>
//                 </thead>
                
//                 <tbody>
//                 {data.map((ele) => {
//                     return (
//                         <tr>
//                             <td style={{ width: "120px", padding: "5px" }}>
//                             {ele.name}
//                             </td>
//                             <td style={{ width: "120px", padding: "5px" }}>
//                             {ele.adhaarCard}
//                             </td>
//                             <td style={{ width: "120px", padding: "5px" }}>
//                             {ele.contactNumber}
//                             </td>
//                             <td style={{ width: "120px", padding: "5px" }}>
//                             {ele.branch}
//                             </td>
//                             <td style={{ width: "100px", padding: "5px" }}>
//                             {ele.sapModule}
//                             </td>
//                             <td style={{ width: "150px", padding: "5px" }}>
//                             {ele.email}
//                             </td>
//                             <td style={{ width: "120px", padding: "5px" }}>
//                             {ele.specialization}
//                             </td>
//                             <td style={{ width: "120px", padding: "5px" }}>
//                             {ele.studentType}
//                             </td>
//                             <td style={{ width: "150px", padding: "5px" }}>
//                             {ele.collegeEmail}
//                             </td>
//                             <td style={{ width: "100px", padding: "5px" }}>
//                             {ele.passoutYear}
//                             </td>
//                             <td style={{ width: "120px", padding: "5px" }}>
//                             {ele.uploadImage}
//                             </td>
//                             <td style={{ width: "100px", padding: "5px" }}>
//                             {ele.applicationFromStatus}
//                             </td>
//                             <td style={{ width: "100px", padding: "5px", }}>
//                              <button onClick={()=> onVerify()}><i class="fas fa-edit"></i></button>{"   "} 
//                             <button onClick={()=> onClicked()}><i class="fa fa-trash" aria-hidden="true"></i></button>
//                             </td>
//                         </tr>
//                     );
//                     })}
                
//                 </tbody>
               
//         </table> 
//         </div>
//     )

// }
//--------------------------------------------------------------------------------
import React, { useEffect, useState } from "react";
import axios from "axios";
import Modal from "../../../Modal";


const VerifyForm = () => {
    const [did,setdid] = useState(0)
    const [stat, setstat] = useState("")
    const [VerifyModal, setVerifyModal] = useState(false)
  
    const handleVerify = () => {
      axios.put(`http://localhost:9190/api/applicationFormStatusUpdate/${did}/${stat}`)
      .then((res)=>{
        console.log(res)
        setVerifyModal(false);
        window.location.reload();
      })
    }
    const handleCancel = () => {
        // hide confirmation modal
        setVerifyModal(false)
      }

    const viewModal = (ele) => {
      setdid(ele.id)
      if(ele.applicationFromStatus === "inactive"){
        setstat("active")
      }
      else{
        setstat("inactive")
      }
      setVerifyModal(true);
    } 
  const [data, setData] = useState([]);
  const [search, setSearch] = useState('')
  useEffect(() => {
            (async () => {
              try {
                const { data } = await axios.get("http://localhost:9190/api/fetchlistofApplicationFormbyfilter",{
                    params: {
                        pagesize : 20,
                        pagenum : 0,
                        applicationFromStatus : "inactive",
                        email: "",
                        studentId: 0,
                        name: "",
                        collegeEmail: "",
                        sapModule: "",
                        contactNumber: "",
                        passoutYear: "",
                        branch: "",
                        specialization: "",
                        studentType: "",
                        adhaarCard: "",
                        uploadImage: "",
                        userId: 0
                    }
                });
                setData(data.records);
                //setSid(data.records.student_id);
                console.log(data);
              } catch (error) {
                console.log("Error");
              }
            })();
          }, []);

  return (
    <>
      <div className="table-nav">
        <input
          className="table-search"
          type="text"
          placeholder="Search Your Name"
          onChange={(e)=> setSearch(e.target.value)}
        />
        <select className="table-drop" name="cars" id="cars">
          <option value="volvo">Department</option>
          <option value="saab">Computer</option>
          <option value="saab">Computer</option>
          <option value="saab">Computer</option>
          <option value="saab">Computer</option>
          <option value="saab">Computer</option>
        </select>
        <table>
          <thead>
            <tr className="main-table top-col-table">
              {/*<th>Student_id</th>*/}
              <th>Adhar card</th>
              <th>Application status</th>
              <th>Branch</th>
              <th>College Email</th>
              <th>Contact No.</th>
              <th>Email</th>
              <th>Query in Application</th>
              <th>Name</th>
              <th>Passout year</th>
              <th>Sap Module</th>
              <th>Specilization</th>
              <th>Student Type</th>
              <th>Upload img</th>
              <th>Action</th>
              {/*<th>User_id</th>*/}
            </tr>
          </thead>
          <tbody>
            {data.filter((item) => {
                  return search.toLowerCase() === '' ? item : (item.name.toLowerCase().includes(search) || item.adhaarCard.toLowerCase().includes(search) || item.sapModule.toLowerCase().includes(search) || item.applicationFromStatus.toLowerCase().includes(search) || item.branch.toLowerCase().includes(search) || item.studentType.toLowerCase().includes(search))
                }).map((ele) => {
              return (
                <tr key={ele.id} className='main-table'>
                  <td style={{ width: "100px", padding: "2px" }}>
                    {ele.adhaarCard}
                  </td>
                  <td style={{ width: "60px", padding: "2px" }}>
                    {ele.applicationFromStatus}
                  </td>
                  <td style={{ width: "60px", padding: "2px" }}>
                    {ele.branch}
                  </td>
                  <td style={{ width: "120px", padding: "2px" }}>
                    {ele.collegeEmail}
                  </td>
                  <td style={{ width: "100px", padding: "2px" }}>
                    {ele.contactNumber}
                  </td>
                  <td style={{ width: "120px", padding: "2px" }}>
                    {ele.email}
                  </td>
                  <td style={{ width: "50px", padding: "2px" }}>
                    {ele.isQueryInApplication}
                  </td>
                  <td style={{ width: "100px", padding: "2px" }}>{ele.name}</td>
                  <td style={{ width: "50px", padding: "2px" }}>
                    {ele.passoutYear}
                  </td>
                  <td style={{ width: "50px", padding: "2px" }}>
                    {ele.sapModule}
                  </td>
                  <td style={{ width: "100px", padding: "2px" }}>
                    {ele.specialization}
                  </td>
                  <td style={{ width: "100px", padding: "2px" }}>
                    {ele.studentType}
                  </td>
                  <td style={{ width: "100px", padding: "2px" }}>
                    {ele.uploadImage}
                  </td>
                  <td style={{ width: "100px", padding: "2px" }}>
                    <button style={{marginRight:"5px"}} onClick={()=> viewModal(ele)}>
                    <i class="far fa-check-square"></i>
                    </button>
                    
                  </td>
                </tr>
              );
            })}
          </tbody>
        </table>
        {VerifyModal && 
          <Modal>
      <div>
        <h2>Change the status of this application ?</h2>
        <div style={{display: "flex", justifyContent : "right", alignItems :"right"}}>
        <button className="btn-md" onClick={handleVerify} style={{marginRight:"10px"}}>Yes</button>
        <button onClick={handleCancel}>No</button>
        </div>
      </div>

          </Modal>
        }
      </div>
    </>
  );
};
export default VerifyForm;
