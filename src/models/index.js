let countries = {};

for (let i = 0; i < 100; i++) {
    const country = {
        id: i,
        country: 'Country ' + i,
        city: 'city ' + i,
    };
    countries[i] = country;
}

export default {
    countries: countries
}
;
