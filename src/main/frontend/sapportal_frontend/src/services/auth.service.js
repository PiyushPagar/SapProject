import axios from "axios";

const API_URL = "http://localhost:9191/api/auth/";

class AuthService {
  login(username, password) {
    return axios
      .post(API_URL + "signin", {
        username,
        password
      })
      .then(response => {
        if (response.data.accessToken) {
          localStorage.setItem("user", JSON.stringify(response.data));
        }

        return response.data;
      });
  }

  logout() {
    localStorage.removeItem("user");
  }

  register(username, email, password) {
    return axios.post(API_URL + "signup", {
      username,
      email,
      password
    });
  }

  getCurrentUser() {
    return JSON.parse(localStorage.getItem('user'));;
  }

  forgotpassword(Email){
    return axios.post(API_URL + "forgotpassword",{Email});
  }

  /*fetchData = () => {
    return axios.get(API_URL + "forgotpassword",{Email})
          .then((response) => setUser(response.data));
  }*/
}

export default new AuthService();
