import {Citizens} from "../../citizen/model/citizens";

export interface CityDetails {

    id: string;

    name: string;

    area: number;

    citizens: Citizens
}
