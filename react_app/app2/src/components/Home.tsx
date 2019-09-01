import * as React from "react";
import * as ReactDOM from "react-dom";
import LoginPage from "./loginPage";

export interface HelloProps { compiler: string; framework: string; }

export const Home = (props: HelloProps) => (
    <React.Fragment>
        <LoginPage/>
    </React.Fragment>
);