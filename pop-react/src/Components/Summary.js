import React from 'react'
import { useState, useEffect } from 'react'
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import Typography from '@mui/material/Typography';


function Summary() {


    // React state variable to hold data, set to null // 
    const [tiedot, setTiedot] = useState(null);

    // we will use async/await to fetch this data // 
    const fetchTiedot = async () => {

        // Api request to fetch data // 
        const response = await fetch("http://localhost:8080/sports");
        const data = await response.json();

        // store the data into variable
        setTiedot(data);
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
                            <Card sx={{ minWidth: 275 }}>
                                <CardContent>
                                <Typography sx={{ fontSize: 14 }} color="text.secondary" gutterBottom>
                                        {tiedot.date}
                                    </Typography>
                                    <Typography sx={{ fontSize: 14 }} color="text.secondary" gutterBottom>
                                        {tiedot.sportName} <br/>
                                        {tiedot.consumption}
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

export default Summary