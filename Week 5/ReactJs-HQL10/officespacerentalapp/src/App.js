import officeImage from "./images/Office.jpg";

function App() {

  const office = {
    name: "Smart Business Center",
    rent: 55000,
    address: "Bangalore, Karnataka"
  };

  const officeList = [

    {
      id: 1,
      name: "Smart Business Center",
      rent: 55000,
      address: "Bangalore"
    },

    {
      id: 2,
      name: "Tech Park Offices",
      rent: 75000,
      address: "Hyderabad"
    },

    {
      id: 3,
      name: "Corporate Hub",
      rent: 65000,
      address: "Pune"
    },

    {
      id: 4,
      name: "Innovation Tower",
      rent: 45000,
      address: "Chennai"
    }

  ];

  return (

    <div style={{ padding: "20px", fontFamily: "Arial" }}>

      <h1>Office Space Rental App</h1>

      <img
        src={officeImage}
        alt="Office Space"
        width="500"
      />

      <hr />

      <h2>Featured Office</h2>

      <h3>Name : {office.name}</h3>

      <h3
        style={{
          color:
            office.rent < 60000
              ? "red"
              : "green"
        }}
      >
        Rent : ₹{office.rent}
      </h3>

      <h3>Address : {office.address}</h3>

      <hr />

      <h2>Available Office Spaces</h2>

      {

        officeList.map((item) => (

          <div
            key={item.id}
            style={{
              border: "1px solid black",
              padding: "15px",
              marginBottom: "15px",
              width: "400px"
            }}
          >

            <h3>{item.name}</h3>

            <p>

              <strong>Rent :</strong>

              <span
                style={{
                  color:
                    item.rent < 60000
                      ? "red"
                      : "green"
                }}
              >

                ₹{item.rent}

              </span>

            </p>

            <p>

              <strong>Address :</strong>

              {item.address}

            </p>

          </div>

        ))

      }

    </div>

  );

}

export default App;