import { makeAutoObservable } from "mobx";
import { renderBg } from "../helpers/renderBg";
class SettingsStore{
    bgImage:ArrayBuffer|string = '';
    constructor(){
        makeAutoObservable(this);
    }
    setBgImage(file:File):void{
        file.arrayBuffer().then((value:ArrayBuffer) => {
            this.bgImage = value;
            renderBg();
        });
    }
}
export default new SettingsStore();