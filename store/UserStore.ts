import { makeAutoObservable } from "mobx";
import { useRandom } from "../hooks/useRandom";
import { UserType } from "../types/UserType";
class UserStore{
    users:UserType[] = [];
    text:string = "";
    constructor(){
        makeAutoObservable(this);
    }
    addUser(user:UserType):void{
        this.users.push(user);
        this.stringify(this.users);
    }
    removeUser():void{
        this.users.pop();
        this.stringify(this.users);
    }
    randomizeUser():string{
        const index = useRandom(0, this.users.length - 1);
        return `${index + 1}. ${this.users[index].name}`;
    }
    changeUser(name: string, index:number):void{
        this.users[index].name = name;
        this.stringify(this.users);
    }
    setCount(length:number):void{
        this.users.length = length;
        for (let index = 0; index < this.users.length; index++) {
            this.users[index] = {name: ''};
        }
        this.stringify(this.users);
    }
    parse(string:string){
        const arr:UserType[] = [];
        this.text = string;
        const template = new RegExp(/\d+.\D+/gim);
        let rows:RegExpMatchArray | null = string.trim().match(template);
        if (rows){
            rows.forEach((el, index) => {
                arr[index] = {name: el.split(".")[1].trim()};
            });
        }
        this.users = arr;
    }
    stringify(users:UserType[]):void{
        let str:string = ``;
        users.forEach((el:UserType, index:number )=> {
            str += `${index + 1}. ${el.name} \n`;
        });
        this.text = str;
    }
}
export default new UserStore();