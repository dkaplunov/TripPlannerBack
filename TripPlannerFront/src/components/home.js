import * as React from "react";
import {LoginForm} from "./loginpage"
import styled from "styled-components"

const Title = styled.h1`
  font-size: 1.5em;
  text-align: center;
  color: palevioletred;
`;


export const Home = (props: HelloProps) => {


    return (
        <React.Fragment>
            <Title>Заголовок</Title>
            <LoginForm />
        </React.Fragment>
    );
};