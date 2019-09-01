const axios = require('axios');

export const testCall = () => {
    return axios.get("http://localhost:4000/");
};

export const login = (userInfo:any) => {
    return axios.post("http://localhost:4000/user/signIn", userInfo);
};

//export default [testCall, login];
