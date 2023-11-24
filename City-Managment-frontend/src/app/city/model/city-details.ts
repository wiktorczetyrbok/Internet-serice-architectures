import {Citizen} from "../../citizen/model/citizen";

export interface CityDetails {

  id: string;

  name: string;

  area: number;

  citizens: Citizen[]
}
