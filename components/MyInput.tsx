import React, { FC } from "react";
import { InputType } from "../types/inputType";
import cl from '../styles/MyInput.module.scss'; 
interface Props{
    type?: InputType;
    placeholder?: string;
    name?: string;
    id?:string;
}
const MyInput:FC<Props> = ({type = InputType.TEXT, 
                            placeholder = "", 
                            name = "", 
                            id = ""}:Props):JSX.Element => {
    return <input type={type} placeholder={placeholder} name={name} id={id}/>
}
export default MyInput;