import axios from "axios";
import authHeader from "./auth-header";
//import UploadFilesService from "./UploadFilesService";
const API_URL = "http://localhost:8080/api/test/";
class UserService {
  getPublicContent() {
    return axios.get(API_URL + "all");
  }
  getUserBoard() {
    return axios.get(API_URL + "user", { headers: authHeader() });
  }
  getModeratorBoard() {
    return axios.get(API_URL + "mod", { headers: authHeader() });
  }
  getAdminBoard() {
    return axios.get(API_URL + "admin", { headers: authHeader() });
  }
  upload(file) {
    let formData = new FormData();
    formData.append("file", file);
    return axios.post(API_URL + "upload", formData, {
      headers: authHeader(),
      //headers: {
      // authHeader()}
      //"Content-Type": "multipart/form-data"
    });
  }
}
export default new UserService();
