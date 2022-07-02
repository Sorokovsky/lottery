import { makeAutoObservable } from "mobx";
import { useRandom } from "../hooks/useRandom";
import { UserType } from "../types/UserType";
class UserStore{
    users:UserType[] = [];
    constructor(){
        makeAutoObservable(this);
    }
    addUser(user:UserType):void{
        this.users.push(user);
    }
    removeUser():void{
        this.users.pop();
    }
    randomizeUser():string{
        const index = useRandom(0, this.users.length - 1);
        return `${index + 1}. ${this.users[index].name}`;
    }
    changeUser(name: string, index:number):void{
        this.users[index].name = name;
    }
    setCount(length:number):void{
        this.users.length = length;
        for (let index = 0; index < this.users.length; index++) {
            this.users[index] = {name: ''};
        }
    }
}
export default new UserStore();