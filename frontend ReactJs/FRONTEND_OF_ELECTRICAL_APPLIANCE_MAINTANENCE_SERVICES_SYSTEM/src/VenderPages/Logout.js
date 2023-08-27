// import React from "react";
// import { Link, useNavigate } from "react-router-dom";
// function Logout(){

//     const navigate = useNavigate();
//     function logout(){
//         localStorage.removeItem('vendor');
//         navigate('/');
//     }
//     return(
//         <div>
//             <h1>Are you sure you want to logout</h1>
//             <table>
//                 <tr>
//                     <td><button onClick={logout}>YES</button></td>
//                     <td><Link to="/dashboard"><button>NO</button></Link></td>
//                 </tr> 
//             </table>
//         </div>
//     )
// }

// export default Logout;
import React from "react";
import { Link, useNavigate } from "react-router-dom";
import "./Logout.css"; // Import the CSS file for styling

function Logout({setIsLoggedIn}) {
  const navigate = useNavigate();

  function logout() {
    localStorage.removeItem('vendor');
    navigate("/");
    setIsLoggedIn(false);
  }

  return (
    <div className="logout-container">
        <div>
      <h1>Are you sure you want to logout</h1>
      </div>
      <div>
      <table id="table">
        <tr>
          <td>
            <button className="logout-button-yes" onClick={logout}>
              YES
            </button>
          </td>
          <td>
            <Link to="/getorders">
              <button className="logout-button-no">NO</button>
            </Link>
          </td>
        </tr>
      </table>
      </div>
    </div>
  );
}

export default Logout;
