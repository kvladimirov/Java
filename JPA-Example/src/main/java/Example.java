import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


public class Example {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("blog-db");
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        try{
            //createNewUser(em, cb);
            //createNewUserAndSeveralPosts(em, cb);
            listAllPosts(em, cb);
            //postsByUsername(em, cb);
            //editExistingUser(em, cb);
            //deleteExistingUser(em, cb);
            //executeNativeSQL(em, cb);
        } finally {
            em.close();
            emf.close();
        }
    }

    private static void executeNativeSQL(EntityManager em, CriteriaBuilder cb) {
        LocalDateTime startDate =
                LocalDateTime.parse("2016-05-19T12:00:00");
        LocalDateTime endDate = LocalDateTime.now();
        Query postsQuery = em.createNativeQuery(
                "SELECT id, title, date, body, author_id FROM posts " +
                        "WHERE CONVERT(date, Date) " +
                        "BETWEEN :startDate AND :endDate", Post.class)
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate);
        List<Post> posts = postsQuery.getResultList();
        for (Post post : posts)
            System.out.println(post);

    }

    private static void deleteExistingUser(EntityManager em, CriteriaBuilder cb) {
        User firstUser = em.find(User.class, 1L);
        em.getTransaction().begin();
        for (Post post : firstUser.getPosts())
            em.remove(post);
        em.remove(firstUser);
        em.getTransaction().commit();
        System.out.println("Deleted existing user #" +
                firstUser.getId());

    }

    private static void editExistingUser(EntityManager em, CriteriaBuilder cb) {
        User firstUser = em.find(User.class, 1L);
        firstUser.setPasswordHash("" + new Date().getTime());
        firstUser.setFullName(firstUser.getFullName() + "2");
        em.getTransaction().begin();
        em.persist(firstUser);
        em.getTransaction().commit();
        System.out.println(
                "Edited existing user #" + firstUser.getId());

    }

    private static void postsByUsername(EntityManager em, CriteriaBuilder cb) {
        Query peshoPosts =
                em.createQuery(
                        "FROM Post p JOIN FETCH p.author " +
                                "WHERE p.author.username " +
                                "LIKE CONCAT(:username, '%') ")
                        .setParameter("username", "pesho");
        List<Post> posts = peshoPosts.getResultList();
        for (Post post : posts) {
            System.out.println(post);
        }

    }

    private static void listAllPosts(EntityManager em, CriteriaBuilder cb) {
        Query allPostsQuerySlow = em.createQuery(
                "SELECT p FROM Post p");
        Query allPostsQuery = em.createQuery(
                "SELECT p FROM Post p JOIN FETCH p.author");
        List<Post> posts =
                allPostsQuery.getResultList();
        for (Post post : posts) {
            System.out.println(post);
        }

    }

    private static void createNewUserAndSeveralPosts(EntityManager em, CriteriaBuilder cb) {
        em.getTransaction().begin();
        User newUser = new User();
        newUser.setUsername("pesho" + new Date().getTime());
        newUser.setPasswordHash("pass12345"); newUser.setFullName("P.Petrov");
        em.persist(newUser);
        System.out.println("Created new user #" + newUser.getId());
        for (int i = 1; i <= 10; i++) {
            Post newPost = new Post();
            newPost.setTitle("Post Title " + i);
            newPost.setBody("<p>Body" + i + "</p>");
            newPost.setAuthor(newUser);
            em.persist(newPost);
            System.out.println("Created new post #" + newPost.getId());
        }
        em.getTransaction().commit();


    }

    private static void createNewUser(EntityManager em, CriteriaBuilder cb) {
        User newUser = new User();
        newUser.setUsername("kosyo");
        newUser.setPasswordHash("1234k");
        newUser.setUsername("Konstantin Vladimirov");
        em.getTransaction().begin();
        em.persist(newUser);
        em.getTransaction().commit();
    }

    private static String bCrypt(String password) {
        bCrypt(password).hashCode();
        return password;
    }
}
