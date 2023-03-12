import React ,{ useEffect, useState} from "react";
import axios from "axios";
export default function VerifyForm() {
    const [data, setData] = useState([]);

    useEffect(() => {
        (async () => {
          try {
            const { data } = await axios.get("http://localhost:9190//api/fetchlistofApplicationFormbyfilter",{
                params: {
                    pagesize : 20,
                    pagenum : 0,
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
            <table border={5} style={{display:"flex",alignContent:"center"}}>
                <thead>
                    <tr>
                    <th>Name</th>
                    <th>Adhar Number</th>
                    <th>Contact Number</th>
                    <th>Branch</th>
                    <th>SAP Module</th>
                    <th>Email</th>
                    <th>Specialization</th>
                    <th>Student Type</th>
                    <th>College Email</th>
                    <th>Passout Year</th>
                    <th>Image</th>
                    <th>Form Status</th>
                    <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                {data.map((ele) => {
                    return (
                        <tr>
                            <td style={{ width: "120px", padding: "8px" }}>
                            {ele.name}
                            </td>
                            <td style={{ width: "120px", padding: "8px" }}>
                            {ele.adhaarCard}
                            </td>
                            <td style={{ width: "120px", padding: "8px" }}>
                            {ele.contactNumber}
                            </td>
                            <td style={{ width: "120px", padding: "8px" }}>
                            {ele.branch}
                            </td>
                            <td style={{ width: "100px", padding: "8px" }}>
                            {ele.sapModule}
                            </td>
                            <td style={{ width: "150px", padding: "8px" }}>
                            {ele.email}
                            </td>
                            <td style={{ width: "120px", padding: "8px" }}>
                            {ele.specialization}
                            </td>
                            <td style={{ width: "120px", padding: "8px" }}>
                            {ele.studentType}
                            </td>
                            <td style={{ width: "150px", padding: "8px" }}>
                            {ele.collegeEmail}
                            </td>
                            <td style={{ width: "100px", padding: "8px" }}>
                            {ele.passoutYear}
                            </td>
                            <td style={{ width: "120px", padding: "8px" }}>
                            {ele.uploadImage}
                            </td>
                            <td style={{ width: "100px", padding: "8px" }}>
                            {ele.applicationFromStatus}
                            </td>
                            <td style={{ width: "100px", padding: "8px" }}>
                            <button><i class="fas fa-edit"></i></button>
                            </td>
                        </tr>
                    )
                })}
                </tbody>
        
        </table>
        </div>
    )

}