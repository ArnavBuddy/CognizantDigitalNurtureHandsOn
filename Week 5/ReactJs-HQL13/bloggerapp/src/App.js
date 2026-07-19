import BookDetails from "./Components/BookDetails";
import BlogDetails from "./Components/BlogDetails";
import CourseDetails from "./Components/CourseDetails";

function App() {

    const showBooks = true;
    const showBlogs = true;
    const showCourses = true;

    return (

        <div
            style={{
                margin: "20px",
                fontFamily: "Arial"
            }}
        >

            <h1>Blogger Application</h1>

            {/* Conditional Rendering using && */}

            {

                showBooks &&

                <BookDetails />

            }

            <hr />

            {/* Conditional Rendering using Ternary Operator */}

            {

                showBlogs

                ?

                <BlogDetails />

                :

                <h2>No Blogs Available</h2>

            }

            <hr />

            {/* Conditional Rendering using if */}

            {

                (() => {

                    if (showCourses) {

                        return <CourseDetails />;

                    }

                    else {

                        return <h2>No Courses Available</h2>;

                    }

                })()

            }

        </div>

    );

}

export default App;