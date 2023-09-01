import { player } from "../add-players/player";

export interface team{
id:number;
teamName:String;
budget:DoubleRange
players:player[];
}