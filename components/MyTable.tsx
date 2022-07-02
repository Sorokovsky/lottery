import { observer } from "mobx-react-lite";
import React, { FC, ReactNode } from "react";
import UserStore from "../store/UserStore";
import { UserType } from "../types/UserType";
const MyTable:FC = observer(():JSX.Element => {
    return (
        <table>{UserStore.users.length !== 0 
            ? UserStore.users.map((user:UserType) => <tr><td>f</td></tr>) 
            : ''}</table>
    )
})
export default MyTable;