function GuestPage() {

    const flights = [

        {
            id: 1,
            from: "Delhi",
            to: "Mumbai",
            price: 4500
        },

        {
            id: 2,
            from: "Bangalore",
            to: "Hyderabad",
            price: 3200
        },

        {
            id: 3,
            from: "Chennai",
            to: "Kolkata",
            price: 5500
        }

    ];

    return (

        <div>

            <h2>Guest Page</h2>

            <h3>Available Flights</h3>

            {

                flights.map((flight) => (

                    <div
                        key={flight.id}
                        style={{
                            border: "1px solid black",
                            padding: "10px",
                            marginBottom: "10px",
                            width: "350px"
                        }}
                    >

                        <p>

                            <strong>From:</strong> {flight.from}

                        </p>

                        <p>

                            <strong>To:</strong> {flight.to}

                        </p>

                        <p>

                            <strong>Price:</strong> ₹{flight.price}

                        </p>

                    </div>

                ))

            }

            <p>

                Login to book your tickets.

            </p>

        </div>

    );

}

export default GuestPage;