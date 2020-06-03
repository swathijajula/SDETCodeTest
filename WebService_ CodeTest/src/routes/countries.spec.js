import {handleError, handleResponse, URL} from "./countries";
import axios from 'axios';
jest.mock('axios');

describe("Countries Route", () => {
    it("URL Should as expected", () => {
        expect(URL).toEqual('https://restcountries.eu/rest/v2/name/');
    });
    it("handleError Should call status with 404", () => {
        const config = {
            status: (code) => {
                expect(code).toEqual(404);
                return {
                    send: (message) => {
                        expect(message).toEqual('Not found');
                    }
                }
            }
        }
        handleError(config);
    });
    it("handleResponse Should call expressResponse.send with {name: string, capital: string}[]", () => {
        const mockData = {
            data: [{
                "name": "Australia",
                "capital": "Canberra",
                "currencies": [{"code": "AUD", "name": "Australian dollar", "symbol": "$"}],
                "languages": [{"iso639_1": "en", "iso639_2": "eng", "name": "English", "nativeName": "English"}],
                "flag": "https://restcountries.eu/data/aus.svg",
                "regionalBlocs": [],
                "cioc": "AUS"
            }]
        };
        const expectedData = [{"name": "Australia", "capital": "Canberra"}];
        const config = {
            send: (data) => {
                expect(data).toEqual(expectedData);
            }
        }
        handleResponse(mockData, config);
    });
});
