package repositoryDAO;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import entity.Group;
import entity.User;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class GroupDao {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public GroupDao() {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistence-unit-name");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void addGroup(Group group) {
        entityManager.getTransaction().begin();
        entityManager.persist(group);
        entityManager.getTransaction().commit();
    }

    public Group getGroupById(Long id) {
        return entityManager.find(Group.class, id);
    }

    public List<Group> getAllGroups() {
        TypedQuery<Group> query = entityManager.createQuery("SELECT g FROM Group g", Group.class);
        return query.getResultList();
    }

    public void addUserToGroup(Group group, User user) {
        entityManager.getTransaction().begin();
        group.getUsers().add(user);
        entityManager.merge(group);
        entityManager.getTransaction().commit();
    }

    public void removeUserFromGroup(Group group, User user) {
        entityManager.getTransaction().begin();
        group.getUsers().remove(user);
        entityManager.merge(group);
        entityManager.getTransaction().commit();
    }

    public void deleteGroup(Long id) {
        entityManager.getTransaction().begin();
        Group group = entityManager.find(Group.class, id);
        entityManager.remove(group);
        entityManager.getTransaction().commit();
    }

    public void close() {
        entityManager.close();
        entityManagerFactory.close();
    }
}

