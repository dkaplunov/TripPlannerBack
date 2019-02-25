import {ACCESS_TOKEN,SERVER_URL} from "./constants"

export const req = (url, data, funOk) => {
    const headers = new Headers({
        'Content-Type': 'application/json',
    });

    if(localStorage.getItem(ACCESS_TOKEN)) {
        headers.append('Authorization', localStorage.getItem(ACCESS_TOKEN));
    }

    let requestObject = {
        method: "POST",
        body: JSON.stringify(data),
        headers: headers,
//        mode: "cors"
    };

    let object = fetch('http://localhost:8080/'+url, requestObject);
        object.then(response => {   //SERVER_URL
        if (response.ok) {
            return response.text();
        } else {
            if (response.status===403) {
                return Promise.reject("false");
            }
        }
    }).then((text) => {
            if (funOk) funOk(text);
        });
};
