using System.Collections.Generic;
using Microsoft.EntityFrameworkCore;

namespace AjuServiis.Repositories
{
    public interface IRepository<TEntity> where TEntity : class
    {
        DbSet<TEntity> Set { get; }

        TEntity Get(params object[] key);

        void Insert(TEntity entity);

        void InsertRange(IEnumerable<TEntity> entities);

        void Update(TEntity entity);

        void Remove(TEntity entity);

        void RemoveByKey(params object[] key);
    }
}