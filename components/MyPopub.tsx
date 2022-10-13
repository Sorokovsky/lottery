import { observer } from "mobx-react-lite";
import { FC, useRef, useState } from "react";
import SettingsStore from "../store/SettingsStore";
import UserStore from "../store/UserStore";
import cl from '../styles/myPopub.module.scss';
const MyPopub:FC = observer(():JSX.Element => {
    const input = useRef<HTMLTextAreaElement>(null);
    return <div className={[cl.popub, 
            SettingsStore.popubIsOpen? cl.open: ""].join(" ")}>
        {SettingsStore.popubIsOpen && <textarea defaultValue={UserStore.text} ref={input}></textarea>}
        <button onClick={() => {
            UserStore.parse(input!.current!.value);
            SettingsStore.popubIsOpen = false;
        }}>Зберегти</button>
    </div>
})
export default MyPopub;