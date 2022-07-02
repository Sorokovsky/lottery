import { observer } from "mobx-react-lite";
import React, { FC, ReactNode } from "react";
import { UserType } from "../types/UserType";
interface Props{
    users:UserType;
    children:ReactNode;
};
const MyTable:FC<Props> = observer(():JSX.Element => {
    return (
        <table></table>
    )
})
export default MyTable;