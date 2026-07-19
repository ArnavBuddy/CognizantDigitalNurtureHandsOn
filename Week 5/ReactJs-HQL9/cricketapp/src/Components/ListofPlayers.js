function ListofPlayers() {

    const players = [

        { name: "Virat Kohli", score: 85 },
        { name: "Rohit Sharma", score: 72 },
        { name: "Shubman Gill", score: 45 },
        { name: "KL Rahul", score: 68 },
        { name: "Hardik Pandya", score: 91 },
        { name: "Ravindra Jadeja", score: 66 },
        { name: "MS Dhoni", score: 98 },
        { name: "Rishabh Pant", score: 55 },
        { name: "Surya Kumar Yadav", score: 80 },
        { name: "Jasprit Bumrah", score: 40 },
        { name: "Mohammed Shami", score: 75 }

    ];

    const below70 = players.filter(player => player.score < 70);

    return (

        <div>

            <h2>List of Players</h2>

            <table border="1" cellPadding="10">

                <thead>

                    <tr>

                        <th>Name</th>
                        <th>Score</th>

                    </tr>

                </thead>

                <tbody>

                    {

                        players.map((player, index) => (

                            <tr key={index}>

                                <td>{player.name}</td>
                                <td>{player.score}</td>

                            </tr>

                        ))

                    }

                </tbody>

            </table>

            <br />

            <h2>Players with Score Below 70</h2>

            <ul>

                {

                    below70.map((player, index) => (

                        <li key={index}>

                            {player.name} - {player.score}

                        </li>

                    ))

                }

            </ul>

        </div>

    );

}

export default ListofPlayers;