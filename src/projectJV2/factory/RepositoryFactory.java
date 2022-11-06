package projectJV2.factory;

import projectJV2.dao.impls.chiThangRepository;
import projectJV2.dao.interfaces.IRepository;
import projectJV2.enums.RepoType;

public class RepositoryFactory {
    private RepositoryFactory(){

    }
    public static IRepository createRepository(RepoType type){
        switch (type){
            case CHITHANG: return new chiThangRepository();
            default:throw new  IllegalArgumentException("thieu tham so roi");
        }
    }
}
