import React, { FC, useRef } from "react";
import { InputType } from "../types/inputType";
import cl from '../styles/FileInput.module.scss';
interface Props{
    placeholder: string;
    accept?:string;
    multi?: boolean;
};
const FileInput:FC<Props> = ({placeholder, accept = '', multi = false}:Props):JSX.Element => {
    const inputRef = useRef<HTMLInputElement>(null);
    const clickHandler = (e:React.MouseEvent<HTMLButtonElement | HTMLAnchorElement>):void => {
        if(null !== inputRef.current){
            inputRef.current.click();
        }
    }
    return(
        <>
        <input ref={inputRef} className={[cl.input].join(" ")} accept={accept} multiple={multi} type={InputType.FILE} />
        <button type="button" className={[cl.btn].join(" ")} onClick={clickHandler}>{placeholder}</button>
        </>
    )
}
export default FileInput;