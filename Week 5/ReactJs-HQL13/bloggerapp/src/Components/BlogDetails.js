function BlogDetails() {

    const blogs = [

        {
            id: 1,
            title: "React Hooks",
            author: "Abhyanand"
        },

        {
            id: 2,
            title: "Learning JavaScript",
            author: "John"
        },

        {
            id: 3,
            title: "Spring Boot Guide",
            author: "Alex"
        }

    ];

    return (

        <div>

            <h2>Blog Details</h2>

            <ul>

                {

                    blogs.map((blog) => (

                        <li key={blog.id}>

                            <strong>{blog.title}</strong>

                            {" - "}

                            {blog.author}

                        </li>

                    ))

                }

            </ul>

        </div>

    );

}

export default BlogDetails;