    package com.example.Project.Example1.BatchManagement.BatchDto;

    public class BatchSummery {
        private Long totalCount;
        private Long ActiveBatch;
        private Long InActiveBatch;

        public Long getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(Long totalCount) {
            this.totalCount = totalCount;
        }

        public Long getActiveBatch() {
            return ActiveBatch;
        }

        public void setActiveBatch(Long activeBatch) {
            ActiveBatch = activeBatch;
        }

        public Long getInActiveBatch() {
            return InActiveBatch;
        }

        public void setInActiveBatch(Long inActiveBatch) {
            InActiveBatch = inActiveBatch;
        }
    }
