import React, { useEffect, useState } from "react";
import axios from "axios";
import Modal from "../../components/pages/dashboard/Modal";

const Table = (right, a) => {
  const [did, setdid] = useState(0);
  const [stat, setstat] = useState("");
  const [title, settitle] = useState("");
  const [ctc, setctc] = useState("");
  const [num, setnum] = useState("");
  const [mail, setmail] = useState("");
  const [desc, setdesc] = useState("");
  const [rname, setrname] = useState("");
  const [rdet, setrdet] = useState("");
  const [uid, setuid] = useState(0);
  const [DeleteModal, setDeleteModal] = useState(false);
  const [VerifyModal, setVerifyModal] = useState(false);
  const [QueryModal, setQueryModal] = useState(false);
  const handleCancel = () => {
    // hide confirmation modal
    setDeleteModal(false);
    setVerifyModal(false);
    setQueryModal(false);
  };

  const handleConfirm = () => {
    axios
      .delete(`http://localhost:9190/api/deleteapplicationform/${did}`)
      .then((res) => {
        console.log(res);
        setDeleteModal(false);
        window.location.reload();
      });
  };
  const handleVerify = () => {
    axios
      .put(
        `http://localhost:9190/api/applicationFormStatusUpdate/${did}/${stat}`
      )
      .then((res) => {
        console.log(res);
        setVerifyModal(false);
        window.location.reload();
      });
  };
  const Modalview = (ele) => {
    setdid(ele.id);
    setDeleteModal(true);
  };
  const viewModal = (ele) => {
    setdid(ele.id);
    if (ele.applicationFromStatus === "inactive") {
      setstat("active");
    } else {
      setstat("inactive");
    }
    setVerifyModal(true);
  };

  const Addquery = () => {
    axios
      .post(
        `http://localhost:9190/applicationFrom/postapplicationformbyapplicationId/${did}`,
        {
          applicationId: did,
          contactDetails: `Contact no.: ${num}, Email: ${mail}`,
          id: did,
          isActive: stat,
          queryDesc: desc,
          queryTitle: title,
          reachoutPersonContactNumber: ctc,
          reachoutPersonDetails: rdet,
          reachoutPersonName: rname,
          userId: uid,
        }
      )
      .then((res) => {
        setQueryModal(false);
        window.location.reload();
      });
  };
  const viewQueryModal = (ele) => {
    setdid(ele.id);
    setstat(ele.applicationFromStatus);
    setmail(ele.email);
    setnum(ele.contactNumber);
    setuid(ele.userId);
    setQueryModal(true);
  };
  const handletitle = async (event) => {
    settitle(event.target.value);
  };
  const handlectc = async (event) => {
    setctc(event.target.value);
  };
  const handlername = async (event) => {
    setrname(event.target.value);
  };
  const handlerdet = async (event) => {
    setrdet(event.target.value);
  };
  const handledesc = async (event) => {
    setdesc(event.target.value);
  };
  const [data, setData] = useState([]);
  const [search, setSearch] = useState("");
  // const OnDelete = (e) => {
  //   axios.post(`http://localhost:9190/api/deleteapplicationform/${e}`)
  //   .then()
  // }
  useEffect(() => {
    (async () => {
      try {
        const { data } = await axios.get(
          "http://localhost:9190/api/getapplicationform"
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
          onChange={(e) => setSearch(e.target.value)}
        />
        <select className="table-drop" name="cars" id="cars">
          <option value="volvo">Department</option>
          <option value="saab">Computer</option>
          <option value="saab">IT</option>
          <option value="saab">Mechanical</option>
          <option value="saab">ECE</option>
          <option value="saab">Civil</option>
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
            {data
              .filter((item) => {
                return search.toLowerCase() === ""
                  ? item
                  : item.name.toLowerCase().includes(search) ||
                      item.adhaarCard.toLowerCase().includes(search) ||
                      item.sapModule.toLowerCase().includes(search) ||
                      item.applicationFromStatus
                        .toLowerCase()
                        .includes(search) ||
                      item.branch.toLowerCase().includes(search) ||
                      item.studentType.toLowerCase().includes(search);
              })
              .map((ele) => {
                return (
                  <tr key={ele.id} className="main-table">
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
                    <td style={{ width: "100px", padding: "2px" }}>
                      {ele.name}
                    </td>
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
                      <button
                        style={{ marginRight: "5px" }}
                        onClick={() => viewModal(ele)}
                      >
                        <i className="far fa-check-square"></i>
                      </button>
                      {"    "}
                      <button
                        style={{ marginRight: "5px" }}
                        onClick={() => viewQueryModal(ele)}
                      >
                        <i className="far fa-edit"></i>
                      </button>
                      {"    "}
                      <button onClick={() => Modalview(ele)}>
                        <i className="fa fa-trash" aria-hidden="true"></i>
                      </button>
                    </td>
                  </tr>
                );
              })}
          </tbody>
        </table>
        {DeleteModal && (
          <Modal>
            <div>
              <h2>Are you sure you want to delete?</h2>
              <div
                style={{
                  display: "flex",
                  justifyContent: "right",
                  alignItems: "right",
                }}
              >
                <button
                  className="btn-md"
                  onClick={handleConfirm}
                  style={{ marginRight: "10px" }}
                >
                  Yes
                </button>
                <button onClick={handleCancel}>No</button>
              </div>
            </div>
          </Modal>
        )}
        {VerifyModal && (
          <Modal>
            <div>
              <h2>Change the status of this application ?</h2>
              <div
                style={{
                  display: "flex",
                  justifyContent: "right",
                  alignItems: "right",
                }}
              >
                <button
                  className="btn-md"
                  onClick={handleVerify}
                  style={{ marginRight: "10px" }}
                >
                  Yes
                </button>
                <button onClick={handleCancel}>No</button>
              </div>
            </div>
          </Modal>
        )}
        {QueryModal && (
          <Modal>
            <div>
              <h2>Enter Query details: </h2>
              <form>
                <label>
                  {" "}
                  Enter Query Title
                  <input
                    type="string"
                    value={title}
                    name="Title"
                    onChange={(e) => handletitle(e)}
                  />
                </label>
                <br />
                <label>
                  {" "}
                  Enter Query Description
                  <input
                    type="string"
                    value={desc}
                    name="Description"
                    onChange={(e) => handledesc(e)}
                  />
                </label>
                <br />
                <label>
                  {" "}
                  Enter Name of faculty to Reachout:
                  <input
                    type="string"
                    value={rname}
                    name="Name of faculty"
                    onChange={(e) => handlername(e)}
                  />
                </label>
                <br />
                <label>
                  {" "}
                  Enter Faculty details:
                  <input
                    type="string"
                    value={rdet}
                    name="Faculty designation"
                    onChange={(e) => handlerdet(e)}
                  />
                </label>
                <br />
                <label>
                  {" "}
                  Enter Contact no. of Faculty:
                  <input
                    type="string"
                    value={ctc}
                    name="Contact"
                    onChange={(e) => handlectc(e)}
                  />
                </label>
                <br />
                <button
                  type="submit"
                  onClick={() => Addquery()}
                  className="btn btn-outline-white"
                  style={{
                    margin: "auto",
                    cursor: "pointer",
                  }}
                >
                  {" "}
                  Post Query{" "}
                </button>
                <button
                  className="btn btn-outline-white"
                  onClick={handleCancel}
                  style={{ marginLeft: "10px", cursor: "pointer" }}
                >
                  cancel
                </button>
              </form>
            </div>
          </Modal>
        )}
      </div>
    </>
  );
};
export default Table;
