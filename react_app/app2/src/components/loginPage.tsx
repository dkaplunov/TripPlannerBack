import * as React from "react";
import * as ReactDOM from "react-dom";
import {Button, Box, TextField} from '@material-ui/core';
import {useState} from "react";
import * as api from './api';

export default function LoginPage() {
    const [state, setState] = useState({show:true,i:'',user:{name:"", password:""}});
    const getNumber = () => state.i;
    return (
        <React.Fragment>
            <TextField
                id="standard-name"
                label="Name"
                onChange={e => {state.user.name=e.target.value;setState(state)}}
                margin="normal"
            />
            <TextField
                id="standard-password-input"
                label="Password"
                onChange={e => {state.user.password=e.target.value;setState(state)}}
                margin="normal"
            />
            <Button variant="contained" color="primary"
                    onClick={()=>{
                        api.login(state.user).then((res:any)=>{state.i=res;setState(state)}).
                        catch((res:any)=>{state.i=res;setState(state)});

                    }}>
                Connect
            </Button>
            <Box hidden={state.show}>
                111 {'-->'+getNumber()} 222
                12345
            </Box>
        </React.Fragment>
    );
}
