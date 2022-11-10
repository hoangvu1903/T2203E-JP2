package exam.factory;

import exam.dao.impls.StudentRepository;
import exam.dao.interfaces.IRepository;
import exam.enums.RepoType;

public class RepositoryFactory {
    private RepositoryFactory() {

    }
    public static IRepository createRepository(RepoType type){
        switch (type) {
            case STUDENT: return (IRepository) new StudentRepository();
            default:throw new IllegalArgumentException("thieu tham so roi");
        }
    }
}