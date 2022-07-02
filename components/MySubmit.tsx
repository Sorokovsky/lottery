import React, { FC } from "react";
import cl from '../styles/MySubmit.module.scss';
interface Props {
    placeholder: string;
};
const MySubmit:FC<Props> = ({placeholder}:Props):JSX.Element => {
    return (
        <button className={[cl.btn].join(" ")} type="submit">{placeholder}</button>
    )
}
export default MySubmit;