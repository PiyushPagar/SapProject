import React, { useEffect, useState } from "react";
import axios from "axios";
import Modal from "../../Modal";



const Deleteform = () => {
  const [did,setdid] = useState(0);
  const [DeleteModal, setDeleteModal] = useState(false)
  const handleCancel = () => {
    // hide confirmation modal
    setDeleteModal(false);
  }

  const handleConfirm = () => {
        axios.delete(`http://localhost:9190/api/deleteapplicationform/${did}`)
        .then((res)=>{
          console.log(res)
          setDeleteModal(false);
          window.location.reload();
        })
  }
  const Modalview = (ele) => {
    setdid(ele.id)
    setDeleteModal(true);
  } 
const [data, setData] = useState([]);
const [search, setSearch] = useState('')
useEffect(() => {
  (async () => {
    try {
      const { data } = await axios.get(
        "http://localhost:9190/api/getapplicationform",
      );
      setData(data);
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
                  <button   onClick={() => Modalview(ele)}>
                    <i className="fa fa-trash" aria-hidden="true"></i>
                  </button>
                  
                </td>
              </tr>
            );
          })}
        </tbody>
      </table>
      {DeleteModal && 
        <Modal>
    <div>
      <h2>Are you sure you want to delete?</h2>
      <div style={{display: "flex", justifyContent : "right", alignItems :"right"}}>
      <button className="btn-md" onClick={handleConfirm} style={{marginRight:"10px"}}>Yes</button>
      <button onClick={handleCancel}>No</button>
      </div>
    </div>

        </Modal>
      }
    </div>
  </>
);
};
export default Deleteform;