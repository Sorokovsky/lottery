import { observer } from "mobx-react-lite";
import { FC, useState } from "react";
import UserStore from "../store/UserStore";
import cl from '../styles/Randomize.module.scss';
const Randomize:FC = observer(():JSX.Element => {
    const [text, setText] = useState<string>("Тут буде переможець.");
    const randomize = ():void => {
        setText(UserStore.randomizeUser());
    }
    return(
        <div className={[cl.flex].join(" ")}>
            <p 
            className={[cl.text].join(" " )}>
                {text}
            </p>
            <button
            onClick={randomize} 
            className={[cl.btn].join(" ")} 
            type="button">
                Розіграти
            </button>
        </div>
    )
})
export default Randomize;