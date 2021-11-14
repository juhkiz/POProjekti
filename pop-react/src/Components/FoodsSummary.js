import React from 'react'
import { useState, useEffect } from 'react'
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import Typography from '@mui/material/Typography';


function FoodsSummary() {


    // React state variable to hold data, set to null // 
    const [tiedot, setTiedot] = useState(null);

    // we will use async/await to fetch this data // 
    const fetchTiedot = async () => {

        // Api request to fetch data // 
        const response = await fetch("http://localhost:8080/foods");
        const sportsData = await response.json();

        // store the data into variable
        setTiedot(sportsData);
    }
    console.log(tiedot)

    useEffect(() => {
        fetchTiedot();
    }, []);
    return (
        <div>
            {tiedot && (
                <div>
                    {tiedot.map((tiedot) => (
                        <div key={tiedot.id}>
                            <Card sx={{ minWidth: 275, maxWidth: 280 }}>
                                <CardContent>
                                    <Typography variant="h5" component="div">
                                        {tiedot.date}
                                    </Typography>
                                    <Typography sx={{ fontSize: 14 }} color="text.secondary" gutterBottom>
                                        {tiedot.mealName} <br />
                                        {tiedot.calories}
                                    </Typography>
                                </CardContent>
                            </Card>
                        </div>
                    ))}
                </div>
            )}
        </div>
    )
}

export default FoodsSummary