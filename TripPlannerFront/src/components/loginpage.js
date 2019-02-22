import React, { Component } from "react";
import {req} from "./requestHandler"
import styled from "styled-components"

export class LoginForm extends Component {
    constructor(props) {
        super(props);
        this.state = {
            userName: null,
            password: null,
        }
        this.loginHandler=this.loginHandler.bind(this);
        this.changeHandler=this.changeHandler.bind(this);
    }


    loginHandler (event) {
        req("api/login", this.state)
    }

    changeHandler (event) {

        let fieldName = event.currentTarget.name;
        let fieldValue = event.currentTarget.value;

        let stateObj={};
        stateObj[fieldName]=fieldValue;

        this.setState(stateObj);
    }

    render () {
        return (
            <form method="POST">
                <input name="userName" onChange={this.changeHandler}/><br/>
                <input name="password" onChange={this.changeHandler}/><br/>
                <input type="button" value="Ok" onClick={this.loginHandler}/>
            </form>
        )
    }
    
}

