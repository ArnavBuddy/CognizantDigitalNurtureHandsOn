import { useState } from "react";

import GuestPage from "./Components/GuestPage";
import UserPage from "./Components/UserPage";

function App() {

    const [loggedIn, setLoggedIn] = useState(false);

    let page;

    if (loggedIn) {

        page = <UserPage />;

    }

    else {

        page = <GuestPage />;

    }

    return (

        <div
            style={{
                textAlign: "center",
                marginTop: "20px"
            }}
        >

            <h1>Flight Ticket Booking App</h1>

            {

                loggedIn ?

                    <button
                        onClick={() =>
                            setLoggedIn(false)
                        }
                    >
                        Logout
                    </button>

                    :

                    <button
                        onClick={() =>
                            setLoggedIn(true)
                        }
                    >
                        Login
                    </button>

            }

            <hr />

            {page}

        </div>

    );

}

export default App;