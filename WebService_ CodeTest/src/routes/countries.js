import {Router} from 'express';
import axios from 'axios';

const router = Router();
export const URL = 'https://restcountries.eu/rest/v2/name/';
export const handleResponse = (apiResponse, expressResponse) => {
    expressResponse.send(apiResponse.data.map(
        data => {
            return {name: data.name, capital: data.capital}
        })
    )
}
export const handleError = (expressResponse) => {
    expressResponse.status(404).send('Not found');
}

export const routeCallBack = (req, res) => {
    axios.get(URL + req.params.id).then(value => {
        handleResponse(value, res);
    }).catch(reason => {
        handleError(reason);
    })
}

export const countriesRoute = router.get('/:id', routeCallBack);

