import { makeAutoObservable } from "mobx";
class SettingsStore{
    bgImage:string = '';
    constructor(){
        makeAutoObservable(this);
    }
}
export default new SettingsStore();