import React, { Component } from "react";
import {req} from "./requestHandler"
import styled from "styled-components"
import {ACCESS_TOKEN} from "./constants";

export class LoginForm extends Component {
    constructor(props) {
        super(props);
        this.state = {
            userName: null,
            password: null,
            authenticated: false
        }
        this.loginHandler=this.loginHandler.bind(this);
        this.changeHandler=this.changeHandler.bind(this);
    }


    loginHandler (event) {
        req("api/login", this.state, (data)=>{
            this.setState({authenticated: true});
            localStorage.setItem(ACCESS_TOKEN, data);
        })
    }

    logoutHandler (me) {
        me.setState({authenticated: false});
        localStorage.setItem(ACCESS_TOKEN, null);
    }

    changeHandler (event) {

        let fieldName = event.currentTarget.name;
        let fieldValue = event.currentTarget.value;

        let stateObj={};
        stateObj[fieldName]=fieldValue;

        this.setState(stateObj);
    }

    showLoginForm () {
        return this.state.authenticated?'none':'block'
    }

    showLogoutForm (me) {
        return !this.state.authenticated?'none':'block'
    }

    render () {
        var me = this;
        return (
            <form method="POST">
                <div style={{display:this.showLoginForm()}}>
                    <input name="userName" onChange={this.changeHandler}/><br/>
                    <input name="password" onChange={this.changeHandler}/><br/>
                    <input type="button" value="Ok" onClick={this.loginHandler}/>
                </div>
                <div style={{display:this.showLogoutForm()}}>
                    <input type="button" value="Logout" onClick={(event) => {this.logoutHandler(me)}}/>
                </div>
            </form>
        )
    }
    
}

